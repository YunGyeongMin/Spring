var modules = 
{
	"RealResources" : [],
	"tempResources" : [],
	"view" : () => {
		if(modules.tempResources.length == 0) {
			$("#LIST").empty().text("데이터가 없습니다.");
			return;
		}
		$("#LIST").empty().html(`<ol></ol>`);
		$.each(modules.tempResources, (index, value) => {
			var html = `<li data-no="${value.no}">
							${value.msg}
						</li>`;
			$("#LIST ol").append(html);
		});
		$("#LIST li").click(modules.detail);
		modules.reset();
	},
	"create" : (event) => {
		event.preventDefault();
		if($("#message").val() == "") {
			alert("입력값이 없습니다.");
			return;
		}
		var data = {
			no: modules.RealResources.length, 
			msg: $("#message").val()
		};
		modules.RealResources.push(data);
		modules.tempResources = modules.RealResources;
		modules.view();
	},
	"read" : (event) => {
		event.preventDefault();
		if($("#keyword").val() != "") {
			modules.tempResources = [];
			$.each(modules.RealResources, (index, value) => {
				if(value.msg.indexOf($("#keyword").val()) > -1) {
					modules.tempResources.push(value);
				}
			});
		} else {
			modules.tempResources = modules.RealResources;
		}
		modules.view();
	},
	"detail" : (event) => {
		var index = $("#LIST li").index(event.target);
		var item = modules.tempResources[index];
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
		$("#update input[type=button]").click(modules.detail_event);
	},
	"detail_event" : (event) => {
		var params = {
				no: Number($("#uNo").val()),
				msg: $("#uMsg").val()
		};
		switch ($("#update input[type=button]").index(event.target)) {
			case 0:
				modules.update(params);
				break;
			case 1:
				modules.delete(params);
				break;
			default:
				modules.cancel();
				break;
		}
	},
	"update" : (params) => {
		$.each(modules.RealResources, (index, value) => {
			if(value.no == params.no) {
				modules.RealResources.splice(index, 1, params);
				modules.tempResources = modules.RealResources;
			}
		});
		modules.view();
	},
	"delete" : (params) => {
		$.each(modules.RealResources, (index, value) => {
			if(value.no == params.no) {
				modules.RealResources.splice(index, 1);
				modules.tempResources = modules.RealResources;
				return false;
			}
		});
		modules.view();
	},
	"cancel" : () => {
		modules.view();
	},
	"reset" : () => {
		$("#message").val("");
		$("#keyword").val("");
	}
};
