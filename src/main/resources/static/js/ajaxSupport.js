

$(function(){

$('#categoryname').change(function(){
  					
  					var catgoryid=$(this).find(":selected").val();
  					$.ajax({
  					  	type: "GET",
  			       		 url: "/loadByCategoryTuturial",
  			       		 data: { "id": catgoryid},
  			       		 contentType: "application/json",
  			       		 success: function (result){
  			       			 
  			       		
  			       		  var html = '';
  	  			            var len = result.length;
  	  			            html += '<option value="0">Select Subject</option>';
  	  			            for (var i = 0; i < len; i++) {
  	  			             html += '<option value="' + result[i] + '">'
  	  			               + result[i]
  	  			               + '</option>';
  	  			            }
  	  			            html += '</option>';
  	  			            
  	  			            $("#inputLanguage").prop('disabled',false);
  	  			            $('#inputLanguage').html(html);
  	  			            
  	  						},
	  						
	 							error : function(err){
	  						console.log("not working. ERROR: "+JSON.stringify(err));
 						}
  						
  						
  					});
  					
  				 
  				  
  				});












});






