$(document).ready(function(){
	$("#create").submit(modules.create);
	$("#read").submit(modules.read);
	modules.view();
});
