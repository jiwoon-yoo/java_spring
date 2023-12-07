function load(id) {
	
	
    fetch("http://localhost:8080/student/" + id)
    .then(data => data.json())
    .then(function(data2) {
        var textToDisplay = JSON.stringify(data2); // 예시로 데이터를 문자열로 변환하여 표시하는 부분입니다.
        document.getElementById("student" + id).innerHTML =textToDisplay;
    })
    .catch(error => {
        console.log('에러 발생:', error);
    });
    
    
}