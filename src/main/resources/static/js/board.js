let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{	//functiin(){}, ()=> this를 바인딩 하기 위해서
			this.save();
		});
		$("#btn-delete").on("click", ()=>{	//functiin(){}, ()=> this를 바인딩 하기 위해서
			this.deleteById();
		});
	},
	
	save: function(){
		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		}

		$.ajax({
				type:"POST"
			, 	url:"/api/board"
			,	data:JSON.stringify(data)	//http body data
			,	contentType:"application/json; charset = utf-8"
			,	dataType: "json"	// 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면) => javascript 데이터로 변경을 해준다.
		}).done(function(resp){
			alert("글쓰기가 완료 되었습니다");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.strigify(error));
		});

	},
	
	deleteById: function(){
		
		alert("여기오냐");
		var id = $("#id").text();
		
		$.ajax({
				type:"DELETE"
			, 	url:"/api/board/"+id
			,	contentType:"application/json; charset = utf-8"
			,	dataType: "json"	// 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면) => javascript 데이터로 변경을 해준다.
		}).done(function(resp){
			alert("삭제가 완료 되었습니다");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.strigify(error));
		});

	},
	
}

index.init();