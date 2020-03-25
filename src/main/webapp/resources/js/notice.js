$(document).ready(function(){
	var type = 0;
	var option = {type: "POST", contentType : "application/json; charset=UTF-8"};
	
	/* Login */
	if(location.pathname == "/notice") {
		$("#login").submit(function(e){
			e.preventDefault();
			var params = {
					"id":	$("#id").val(),
					"pwd":	$("#pwd").val()		
			};
			option.url = "/login";
			option.data = JSON.stringify(params);
			$.ajax(option).done(function(d) {
				$("#state p").empty();
				if(d.state == 1) {
					$("#state p").text(d.nm + "님 환영합니다.");
					setTimeout(function(){
						location.href = "/main";
					}, 1500);
				} else {
					$("#state p").text(d.msg);
					setTimeout(function(){
						$("#state p").empty();
					}, 1500);
				}
			});
		});
	}
	
	/* Main */
	if(location.pathname == "/main") {
		$("#create").click(function(){
			$("#no").val("");
			$("#uNo").val("");
			$("#title").val("");
			$("#content").val("");
			$("#msg").removeClass("disNone");
			$("#list tbody tr").removeClass("active");
			type = 1;
		});
		
		$("#logout").click(function(){
			location.href = "/logout";
		});
		
		$("#msg form").submit(function(e) {
			e.preventDefault();
			
			if(type == 1) {
				var params = {
						"title":	$("#title").val(),
						"content":	$("#content").val()		
				};
				option.url = "/insert";
				option.data = JSON.stringify(params);
			} else if(type == 2) {
				var params = {
						"no":		$("#no").val(),
						"uNo":		$("#uNo").val(),
						"title":	$("#title").val(),
						"content":	$("#content").val()		
				};
				option.url = "/update";
				option.data = JSON.stringify(params);
			}
			
			$.ajax(option).done(function(d) {
				if(d.state == 1) {
					$("#msg").addClass("disNone");
					type = 0;
					view(d);
				} else {
					alert(d.msg);
				}
			});
		});
		
		$("#msg form input[type=button]").click(function() {
			$("#no").val("");
			$("#uNo").val("");
			$("#title").val("");
			$("#content").val("");
			$("#msg").addClass("disNone");
			$("#list tbody tr").removeClass("active");
			type = 0;
		});
		
		var select = function(){
			option.url = "/select";
			$.ajax(option).done(view);
		};
		
		var view = function(d) {
			if(d.state == 1) {
				$("#list tbody").empty();
				$.each(d.result, function(index, item) {
					var html = `
								<tr>
									<td>${item.no}</td>
									<td>${item.title}</td>
									<td>${item.regDate}</td>
									<td><button type="button">삭제</button></td>
								</tr>
							   `;
					$("#list tbody").append(html);
				});
				detail(d);
			} else {
				alert(d.msg);
			}
		}
		
		var detail = function(d) {
			$("#list tbody tr").click(function() {
				$("#msg").removeClass("disNone");
				type = 2;
				var index = $("#list tbody tr").index(this);
				$("#list tbody tr").removeClass("active");
				$("#list tbody tr").eq(index).addClass("active");
				$("#no").val(d.result[index].no);
				$("#uNo").val(d.result[index].uNo);
				$("#title").val(d.result[index].title);
				$("#content").val(d.result[index].content);
			});
			
			$("#list tbody tr button").click(function() {
				var index = $("#list tbody tr button").index(this);
				var params = d.result[index];
				option.url = "/delete";
				option.data = JSON.stringify(params);
				$.ajax(option).done(function(d) {
					if(d.state == 1) {
						$("#msg").addClass("disNone");
						type = 0;
						view(d);
					} else {
						alert(d.msg);
					}
				});
			});
		}
	
		select();
	}
	
});