$(function(){
    var indexViewModel = new Vue({
        el: '#item-list',
        data:{
            items:[]
        },
        mounted: function(){
            self = this;
            axios.get('/api/item/')
                .then(function (response) {
                    self.items = response.data;
                    console.log(self.items);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    });
})
