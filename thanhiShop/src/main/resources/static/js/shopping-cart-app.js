const app = angular.module("shopping-cart-app", []);
// app.config(function ($httpProvider) {
//    var auth = 'Basic ${btoa("ADMIN:123")}';
//    $httpProvider.defaults.headers.common["Authorization"] = auth;
// });
app.controller("shopping-cart-ctrl", function($scope, $http){
    $scope.cart = {
        items: [],
        add(id){
            var item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                let url = "http://localhost:8080/rest/products/" + id;
                $http.get(url).then(resp => {
                    console.log(resp.data)
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        remove(id){
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },
        clear(){
            this.items = [];
            this.saveToLocalStorage();
        },
        amt_of(id){},
        get count(){
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        get amount(){
            return this.items
                .map(item => item.qty * item.sellPrice)
                .reduce((total, qty) => total += qty, 0);
        },
        saveToLocalStorage(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        loadFromLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json):[];
        }
    };
    $scope.cart.loadFromLocalStorage();
    $scope.order = {
        createDate: new Date(),
        address: "",
        account: {username: $("#username").text()},
        get orderDetailList(){
            return $scope.cart.items.map(item => {
                return {
                    product:{id:item.id},
                    price: item.sellPrice,
                    quantity: item.qty

                }
            });
        },
        purchase(){
            var order = angular.copy(this);
            console.log(order);
            $http.post('http://localhost:8080/rest/orders', JSON.stringify(order)).then(resp => {
                // $scope.cart.clear();
                swal({
                    title: "Good job!",
                    text: "Order Success!",
                    icon: "success",
                    button: "OK",
                })
                //     .then(function () {
                //     window.location.href = "/order/detail"+ resp.data.id;
                // });
            }).catch(error => {
                swal({
                    title: "ERROR!",
                    text: "Order failed!",
                    icon: "error",
                    button: "OK",
                });
                console.log(error);
            });

        }
    }
});