angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = '/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                max_cost: $scope.filter ? $scope.filter.max_cost : null,
                min_cost: $scope.filter ? $scope.filter.min_cost : null
            }
        }).then(function (response) {
            console.log(response.data);
            $scope.ProductPage = response.data.content;
        });
    };

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    };

    $scope.updateProduct = function () {
            $http.post(contextPath + '/products', $scope.update_product)
                .then(function (response) {
                    console.log(response.data);
                    $scope.loadProducts();
                });
        };
    $scope.loadBasket = function () {
                $http.get(contextPath + '/products/baskets')
                    .then(function (response) {
                        console.log(response.data);
                        $scope.BasketList = response.data;
                    });
            };
    $scope.sendToBasket = function (productId) {
            $http.get(contextPath + '/products/baskets/'+ productId)
                .then(function (response) {
                    $scope.loadBasket();
                });
        };
    $scope.deleteFromBasket = function (basketId) {
            $http.delete(contextPath + '/products/baskets/' + basketId)
                .then(function (response) {
                    $scope.loadBasket();
                });
        };
    $scope.loadProducts();
    $scope.loadBasket();
});