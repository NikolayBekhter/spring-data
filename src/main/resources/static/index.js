angular.module('app', []).controller('indexController', function ($scope, $http) {
    console.log("начало");
    const contextPath = 'http://localhoct:8081';

    $scope.loadProducts = function () {
        console.log(2);
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response.data);
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.updateProduct = function () {
        console.log($scope.updatedProduct);

    }

    console.log(1);
    $scope.loadProducts();

});