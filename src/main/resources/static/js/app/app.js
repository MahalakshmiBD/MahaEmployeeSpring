'use strict'
var demoApp = angular.module('demo', ['ui.bootstrap', 'demo.controllers',
    'demo.services'
]);
demoApp.constant("CONSTANTS", {
    getemployeeById: "/readEmployee/{id}",
    deleteEmploteeByID: "/deleteEmployee/{id}",
    createEmployee: "/createEmployee",
    updateEmployee: "/updateEmployee/{id}"
});