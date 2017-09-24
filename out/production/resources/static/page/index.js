
$(function(){
    var indexViewModel = new Vue({
        el: '#item-list',
        data:{
            items: [],
            orders: [],
        },
        mounted: function(){
            self = this;
            axios.get('/api/item/')
                .then(function (response) {
                    self.items = response.data;
                    self.items.forEach(function (t) { t.quantity = ""; });
                })
                .catch(function (error) {
                    console.log(error);
                }).then(function(){
                    axios.get('/api/order/')
                        .then(function(response){ self.orders = response.data; })
                        .catch(function(error){
                            console.log(error);
                        });
                });
        },
        methods:{
            onSubmit:function (event) {
                self = this;
                var formData = [];
                self.items.forEach(function (t) {
                    if(t.quantity != ""){
                        formData.push({'itemName':t.item.name, 'quantity':t.quantity});
                    }
                });
                axios.post('/api/item/',formData)
                    .then(function (response) {
                        axios.get('/api/item/')
                            .then(function (response) {
                                self.items = response.data;
                            }).catch(function (error) {
                                console.log(error);
                            });
                    }).catch(function () {
                        bootbox.alert("Please check your order.");
                    }).then(function(){
                        axios.get('/api/order/')
                            .then(function(response){
                                self.orders = response.data;
                                self.items.forEach(function (t) { t.quantity = ""; });
                            }).catch(function(error){
                                console.log(error);
                            });
                    });

            }
        }
    });
})
