var mapContainer = document.getElementById('map'), // 지도를 표시할 div 

mapOption = { 
    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 4 // 지도의 확대 레벨 
}; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var geocoder = new kakao.maps.services.Geocoder(); // 주소-좌표 변환 객체를 생성합니다

var marker = new kakao.maps.Marker({  
        map: map, 
        position: map.getCenter()
    }); 


// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
function getCurrentLocation() {
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
				        
	        var locPosition = new kakao.maps.LatLng(lat, lon) // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다

	        displayMarker(locPosition)
	            
	        searchAddrFromCoords(lon, lat, displayCenterInfo)
	            
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667)    
		
		alert('현재 위치를 찾을 수 없습니다. 검색을 통해 설정해주세요.')
	        
	    displayMarker(locPosition);
	}
}

function displayMarker(locPosition) {

	marker.setPosition(locPosition)
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}

function searchAddrFromCoords(lon, lat, callback) {
    // 좌표로 행정동 주소 정보를 요청합니다
    geocoder.coord2RegionCode(lon, lat, callback);         
}

function displayCenterInfo(result, status) {
    if (status === kakao.maps.services.Status.OK) {
        var infoDiv = document.getElementById('region');

        for(var i = 0; i < result.length; i++) {
            // 행정동의 region_type 값은 'H' 이므로

            if (result[i].region_type === 'H') {
                infoDiv.value = result[i].address_name;
                break;
            }
        }
    }    
}