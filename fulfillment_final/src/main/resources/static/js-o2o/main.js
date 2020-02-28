var contextRoot = null;

$(document).ready(function() {
	contextRoot = $('meta[name=contextRoot]').attr("content");
	if (!contextRoot)
		contextRoot = '';

	$('.o2o-nav-link').click(function(e) {
		e.preventDefault();

		//초기화
		$('.o2o-nav-link').each(function() {
			$(this).parent().removeClass('active');
		});

		$(this).parent().addClass('active');
	});
	//reload();

	feather.replace();
});

function reload() {
	console.log($("#meal-date").val());

	$.ajax({
		url : contextRoot + '/api/1.0/mealmenus?currentDate=' + $("#meal-date").val(),
		success : function(data) {
		}
	});
}
