var contextRoot = null;
var productId = null;

$(document).ready(function() {
	contextRoot = $('meta[name=contextRoot]').attr("content");
	if (!contextRoot)
		contextRoot = '';
	productId = $('meta[name=productId]').attr("content");

	$('.o2o-nav-link').click(function(e) {
		e.preventDefault();

		//초기화
		$('.o2o-nav-link').each(function() {
			$(this).parent().removeClass('active');
		});

		$(this).parent().addClass('active');
	});
	reload();
});

function reload() {
	console.log($("#meal-date").val());

	$.ajax({
		url : contextRoot + '/api/1.0/category?id=' + productId,
		success : function(data) {
			console.log(data);
			if (data != null) {
				$('#product_main_image').attr('src', data.imagePath);
				$('#product_main_title').html(data.title);
				if (data.detail != null) {
					
					$('#product_main_cost').html(numberWithCommas(data.detail.cost) + "원");
				}
				$('#product_main_description').html(data.description);
			}
		}
	});
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}