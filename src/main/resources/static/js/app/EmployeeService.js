'use strict'
angular.module('demo.services', []).
factory('EmployeeService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    /**service.getUserById = function(userId) {
        var url = CONSTANTS.getUserByIdUrl + userId;
        return $http.get(url);
    }
    service.getAllUsers = function() {
        return $http.get(CONSTANTS.getAllUsers);
    } */
    service.createEmployee = function(employee) {
        return $http.post(CONSTANTS.createEmployee, employee);
    } 
    return service;
}]);