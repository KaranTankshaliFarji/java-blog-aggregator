/**
 * 
 */

$(document).ready(function(){
	$(".triggerRemove").click(function(e){
		e.preventDefault();
		$("#modalRemove .removeBtn").Attr("href",$(this).attr("href"));
		$("#modalRemove").modal();
	});
});
