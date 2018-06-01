var user = new Vue({
    el: '#viewPage',
    data: {
        user: {
            userAccount: 'hahaha',
            userPassword: '123456'
        }
    },
    methods:{
        submitData:function(){
            alert(this.user.userName+this.user.password);
            alert(JSON.stringify(this.user));
            $.ajax({
                url:"/authc/doLogin",
                dataType:"json",
                contentType:"application/json",
                type:"POST",
                data:JSON.stringify(this.user),
                success:function(data){
                    alert(JSON.stringify(data));
                },
                error:function(){
                    alert("哈哈，出错了！");
                }
            });
        }
    }
});

var myViewMothods = {

}