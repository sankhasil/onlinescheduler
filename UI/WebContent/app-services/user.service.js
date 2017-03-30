(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http','$rootscope'];
    function UserService($http) {
        var service = {};

        service.GetAllJobs = GetAllJobs;
//        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.Create = Create;
        service.CreateJob = CreateJob;
        service.DeleteJob = DeleteJob;
        service.ActivateJob = ActivateJob;
        service.DeActivateJob = DeActivateJob;
//        service.Update = Update;
//        service.Delete = Delete;

        return service;
        
//        function GetAll() {
//            return $http.get('/api/users').then(handleSuccess, handleError('Error getting all users'));
//        }
// 
//        function GetById(id) {
//            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
//        }
// 
//        function GetByUsername(username) {
//            return $http.get('/api/users/' + username).then(handleSuccess, handleError('Error getting user by username'));
//        }
// 
//        function Create(user) {
//            return $http.post('/api/users', user).then(handleSuccess, handleError('Error creating user'));
//        }
// 
//        function Update(user) {
//            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
//        }
// 
//        function Delete(id) {
//            return $http.delete('/api/users/' + id).then(handleSuccess, handleError('Error deleting user'));
//        }
//        
        function GetAllJobs(user_id) {
            return $http.get('http://localhost:8080/job/getAll/'+user_id).then(handleSuccess, handleError('Error getting all Jobs'));
        }
//
//        function GetById(id) {
//            return $http.get('http://localhost:8080/user/get/' + id).then(handleSuccess, handleError('Error getting user by id'));
//        }

        function GetByUsername(username) {
           return $http.get('http://localhost:8080/user/get/' + username).then(handleSuccess, handleError('Error getting user by username'));
        }

        function Create(user) {
            return $http.post('http://localhost:8080/user/add', user).then(handleSuccess, handleError('Error creating user'));
        }
        
        function CreateJob(job,user) {
        	job.user_id = user.id;
            return $http.post('http://localhost:8080/job/add',job).then(handleSuccess, handleError('Error creating Job'));
        }
        function DeleteJob(id) {
            return $http.delete('http://localhost:8080/job/delete/'+id).then(handleSuccess, handleError('Error deleting Job'));
        }
        function ActivateJob(id) {
            return $http.post('http://localhost:8080/job/activate/'+id).then(handleSuccess, handleError('Error activating Job'));
        }
        function DeActivateJob(id) {
            return $http.post('http://localhost:8080/job/deActivate/'+id).then(handleSuccess, handleError('Error deactivating Job'));
        }

//        function Update(user) {
//            return $http.put('http://localhost:8080/user/update/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
//        }
//
//        function Delete(id) {
//            return $http.delete('http://localhost:8080/user/delete/' + id).then(handleSuccess, handleError('Error deleting user'));
//        }

        // private functions

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
