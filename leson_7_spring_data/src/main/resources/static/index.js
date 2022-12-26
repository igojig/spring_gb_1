angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
//        $http({
//            url: contextPath + '/products',
//            method: 'DELETE',
//            params: {
//                productId
//            }
//        }).then(function (response){
//             $scope.loadProducts();
//        });
    };

    $scope.changePrice = function (productId, delta) {
        $http({
            url: contextPath + '/products',
            method: 'PUT',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.submitProductForm = function(){
        $http.post(contextPath + '/products', $scope.product).
            then (function (response){
                $scope.loadProducts();
            });
    };

     $scope.originalProduct = {
                    id: "",
                    title: "",
                    price: ""
                };

     $scope.product = angular.copy($scope.originalProduct);


    $scope.loadProducts();


});