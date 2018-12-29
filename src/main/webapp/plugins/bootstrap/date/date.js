//日期控件
$scope.dateOptions = {
     startingDay: 1,
     class: 'datepicker'
};
//日期控件
   $scope.format = "yyyy-MM-dd";
$scope.openDatepicker = function($event, i) {
$event.preventDefault();
$event.stopPropagation();
if(i==1){
$scope.loanDate = true;
}
}