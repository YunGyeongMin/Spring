$(document).ready(function(){
	var resources = [];
	$("#create").submit(function(event){
		event.preventDefault();
		$.ajax({
			type: "post",
			url: "/crud/create",
			data: {msg: $("#message").val()}
		}).done(function(d){
			if(d > 0) {
				$("#message").val("");
				read();
			} else {
				alert("입력하신 값이 저장되지 않았습니다.");
			}
		});
	});
	$("#read").submit(function(event){
		event.preventDefault();
		read();
	});
	var read = function(){
		$.ajax({
			type: "post",
			url: "/crud/read",
			data: {keyword: $("#keyword").val()}			
		}).done(function(d) {
			$("#keyword").val("");
			resources = d;
			view();
		});
	}
	var view = function(){
		$("#LIST").empty();
		$("#LIST").html(`<ol></ol>`);
		$.each(resources, function(index, item) {
			var html = `
						<li data-no="${index}">
							${item.msg}
						</li>
			           `;
			$("#LIST ol").append(html);
		});
		$("#LIST li").click(function(){
			var index = $("#LIST li").index(this);
			var item = resources[index];
			var html = `
						<form id="update">
							<label for="uNo">번호</label>
							<input type="text" id="uNo"  value="${item.no}" readonly="readonly"><br>
							<label for="uMsg">내용</label>
							<input type="text"   id="uMsg" value="${item.msg}"><br>
							<input type="button" value="수정">
							<input type="button" value="삭제">
							<input type="button" value="닫기">
						</form>
			           `;
			$("#LIST").empty().html(html);
			$("#update input[type=button]").click(function(){
				var target = $("#update input[type=button]").index(this);
				switch (target) {
				case 0:
					$.ajax({
						type: "post",
						url: "/crud/update",
						data: {
								no: $("#uNo").val(),
								msg: $("#uMsg").val()
							  }
					}).done(function(d){
						read();
					});
					break;
				case 1:
					$.ajax({
						type: "post",
						url: "/crud/delete",
						data: {
							no: $("#uNo").val()
						  }		
					}).done(function(d){
						read();
					});					
					break;
				default:
					read();
					break;
				}
			});
		});
	}
	
	var timer = null;
	
	$("#BTN").click(function(){
		if(timer == null) {
			timer = setInterval(() => {
				read();
			}, 1000);
		} else {
			clearInterval(timer);
		}
	});
	
	read();
});