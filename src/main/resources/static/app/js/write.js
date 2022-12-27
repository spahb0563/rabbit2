const write = {
    init: function () {
        const _this = this;       
        
        $('#btn-write').on('click', function () {
            _this.write();
        });
    },

    	write: function () {
        const data = {
			title : $('#title').val(),
			content  : $ ('#content').val(),
			price : $('#price').val(),
			status : 'ON_SALE',
			sellerId : 2,
			categoryId : $('#category option:selected').val(),
			regionId : 1
        }

        $.ajax({
            type : 'POST',
            url : '/api/v1/item',
            dataType: 'json',
            contentType: 'application/json; charset=utf8',
            data: JSON.stringify(data)
        }).done(function (result){
            alert('등록 완료');
            console.log(result);
            const item = result
            //window.location.href= '/item/'+item.id;
        }).fail(function (error){
			console.log(error)
            alert('등록 실패');
        });
    },
}

write.init();

