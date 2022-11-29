angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8081';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response.data);
                $scope.ProductList = response.data;
            });
    };

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.updateProduct = function () {
        $http({
            url: contextPath + '/products/add',
            method: 'post',
            params: {
                title: $scope.update_product.title,
                cost: $scope.update_product.cost
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.findAllBetween = function () {
            $http({
                url: contextPath + '/products/between',
                method: 'get',
                params: {
                    begin: $scope.begin.cost,
                    end: $scope.end.cost
                }
            }).then(function (response) {
                $scope.ProductList = response.data;
            });
        };

    $scope.loadProducts();

});