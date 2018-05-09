var user = new Vue({
    el: '#viewPage',
    data: {
        user: {
            userName: 'hahaha',
            password: '123456'
        }
    },
    methods:{
        submitData:function(){
            alert(this.user.userName+this.user.password);
        }
    }
});

var myViewMothods = {

}