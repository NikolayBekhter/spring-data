angular.module('app', []).controller('usersController', function ($scope, $http) {
    const contextPath = '/api/v1';

    $scope.loadUsers = function () {
            $http.get(contextPath + '/users')
                .then(function (response) {
                    console.log(response.data);
                    $scope.UsersList = response.data;
                });
        };

    $scope.deleteUser = function (userId) {
        $http.delete(contextPath + '/users/' + userId)
            .then(function (response) {
                $scope.loadUsers();
            });
    }

    $scope.updateUser = function () {
            console.log($scope.update_user);
            $http.post(contextPath + '/users', $scope.update_user)
                .then(function (response) {
                    console.log(response.data);
                    $scope.loadUsers();
                });
        };
    $scope.loadUsers();
});