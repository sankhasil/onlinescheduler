(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', '$rootScope'];
    function HomeController(UserService, $rootScope) {
        var vm = this;

        vm.user = null;
        vm.allJobs = [];
//        vm.deleteUser = deleteUser;
        vm.createJob = createJob;
        vm.deleteJob = deleteJob;
        vm.activateJob = activateJob;
        initController();

        function initController() {
            loadCurrentUser();
            loadAllJobs();
        }

        function loadCurrentUser() {
            UserService.GetByUsername($rootScope.globals.currentUser.username)
                .then(function (user) {
                    vm.user = user;
                });
        }

        function createJob() {
            UserService.CreateJob(vm.job)
                .then(function () {
                    console.log("success");
                });
        }
        
        function deleteJob(id) {
            UserService.DeleteJob(id)
                .then(function () {
                    console.log("success");
                });
        }
        function activateJob(id) {
            UserService.ActivateJob(id)
                .then(function () {
                    console.log("success");
                });
        }
        
        function loadAllJobs() {
            UserService.GetAll(vm.user.id)
                .then(function (jobs) {
                    vm.jobs = jobs;
                });
        }
//
//        function deleteUser(id) {
//            UserService.Delete(id)
//            .then(function () {
//                loadAllUsers();
//            });
//        }
    }

})();