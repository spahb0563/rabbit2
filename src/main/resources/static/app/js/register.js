const register = {
    init: function () {
        const _this = this;
        $('#btn-register').on('click', function () {
            _this.register();
        });
    },

    register: function () {
        const data = {
			email : $('#email').val(),
			password : $('#password').val(),
			nickname : $('#nickname').val(),
			address : $('#region').val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/member',
            dataType: 'json',
            contentType: 'application/json; charset=utf8',
            data: JSON.stringify(data)
        }).done(function (result){
            alert('회원가입 성공');
            window.location.href= '/';
        }).fail(function (error){
            alert('회원가입 실패');
        });
    }
};

register.init();

