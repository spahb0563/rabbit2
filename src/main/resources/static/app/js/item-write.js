const itemWrite = {
    init: function () {
        const _this = this;
        
        $('#btn-write').on('click', function () {
            _this.write();
        }),
        
        $('#check-share').on('change', function () {
			_this.share();
		})
    },

    	write: function () {
		
		const share = $('#check-share').is(":checked");
	
		const price = share ? 0 : $('#price');
		const status = share ? 'SHARING' : 'ON_SALE';
	
        const data = {
			title : $('#title').val(),
			content  : $ ('#content').val(),
			price : price,
			status : status,
			sellerId : 1,
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
            window.location.href= '/item/'+ result;
        }).fail(function (error){
            alert('등록 실패');
        })},
    
        share : function () {
			if($("#check-share").is(":checked")) {
				$("#price").val(0);
				$("#price").attr("disabled", true);
			}else{
				$("#price").attr("disabled", false);
			}
		}			
		
}

itemWrite.init();

