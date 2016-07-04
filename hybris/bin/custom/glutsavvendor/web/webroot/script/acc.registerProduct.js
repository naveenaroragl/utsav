
$(document).ready(function() {
	$(document).on('click', ".categorySelect", function() {
		currentSelection=($(this).parent().parent().index());
		console.log(currentSelection);
		var findcategory = $(this).val();
		 $.ajax({
	            type: "POST",
	            url: "fetchSubCategories",
	            data: "categoryName="+findcategory,
	            async: false,
	            success: function (data) {
	        		 $("table td").each(function()				 {
	        			 if($(this).index()>currentSelection)			 {
	        				 $(this).remove();
	        				 }
	        		});
	        		 
	        		if(!jQuery.isEmptyObject(data)){
	        		 total = $("select").size() + 1;                                         // 1-
	        		 var s = $("<select id=\"subcategorySel"+total+"\" name=\"subcategorySel"+total+"\" style=\"width: 300px;\" size=\"10\"  class=\"categorySelect\" />");            // 4-
	        		 for(var val in data) {
	        		     $("<option />", {value: val, text: data[val]}).appendTo(s);
	        		 }
	        		 $("table tr:last").append("<td style=\"padding: 30px;\"><div></div></td>");
	        		 $("table td:last div").append("<label>Select a suitable category</label><br/>").append(s);
	        		 $("#continueCategory").prop("disabled", true);
	        		} else{
	        			$("#continueCategory").prop("disabled", false);
	        		}
            }
	        });
	});
});
