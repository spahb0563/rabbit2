$('#search-region').autocomplete({
	minLength : 2,
	source : function(request, response) {
		data = {
			address : $('#search-region').val()
		};
		
		$.ajax({
			type : 'GET',
			url: '/api/v1/region', 
			dataType: 'json',
			data : data
		}).done(function (result){
			response(
                 $.map(result, function(item) {
			         return { 
		        	     label : item.address,
		                 value : item.address,
		                 lat : item.lat,
		                 lon : item.lon
			         };
				 })
			);
        });
	},
	select : function(event, ui) {
		$('#region').val(ui.item.value);
		
		var locPosition = new kakao.maps.LatLng(ui.item.lat, ui.item.lon), 
        message = '<div>설정 위치</div>';
	            
        displayMarker(locPosition, message);
	}
});