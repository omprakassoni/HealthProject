

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
  	  			            html += '<option value="0">Select language</option>';
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

			/*here we write code for calling Topic*/


		$('#categoryId').change(function(){
  					
  					var catgoryid=$(this).find(":selected").val();
  					$.ajax({
  					  	type: "GET",
  			       		 url: "/loadByCategoryTuturialTopic",
  			       		 data: { "id": catgoryid},
  			       		 contentType: "application/json",
  			       		 success: function (result){
  			       			 
  			       		
  			       		  var html = '';
  	  			            var len = result.length;
  	  			            html += '<option value="0">Select Topic</option>';
  	  			            for (var i = 0; i < len; i++) {
  	  			             html += '<option value="' + result[i] + '">'
  	  			               + result[i]
  	  			               + '</option>';
  	  			            }
  	  			            html += '</option>';
  	  			            
  	  			            $("#inputTopic").prop('disabled',false);
  	  			            $('#inputTopic').html(html);
  	  			            
  	  						},
	  						
	 							error : function(err){
	  						console.log("not working. ERROR: "+JSON.stringify(err));
 						}
	
  					});
  					
  				 
  				  
  				});
	
		
		
		/*here we write code for calling language*/

		$('#categoryId').change(function(){
				
  					var catgoryid=$(this).find(":selected").val();		
  					$.ajax({
  						
  					  	type: "GET",
  			       		 url: "/loadByCategoryTuturial",
  			       		 data: { "id": catgoryid},
  			       		 contentType: "application/json",
  			       		 success: function (result){
  			       			 
  			       		
  			       		  var html = '';
  	  			            var len = result.length;
  	  			            html += '<option value="0">Select language</option>';
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


		/////////////
		
		$('#catId').change(function(){
			
		
				var catgoryid=$(this).find(":selected").val();
				$.ajax({
				  	type: "GET",
		       		 url: "/loadByCategoryTuturial",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select Topic</option>';
			            for (var i = 0; i < len; i++) {
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputLanguage1").prop('disabled',false);
			            $('#inputLanguage1').html(html);

						},
						
						
						error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}
					
					
				});
		
			  
			});
				
		
	/*	here is code for download question*/
		
		
		$('#inputLanguage1').change(function(){
					

				var catgoryid=$(this).find(":selected").val();
				$.ajax({	
				  	type: "GET",
		       		 url: "/downloadQuestion",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<a href="#">Click To Open</a>';
			            for (var i = 0; i < len; i++) {
			            	
			            	
			             html +='<a her="' + result[i] + '">'
			               +'<a href='+ result[i]+'>'+result[i]+'</a>'   + '</option>';
		             
			         
			            }
			            html += '</option>';
			            
			            $("#input").prop('disabled',false);
			            
			            $('#inputdiv').html(html);
			            

						},
						
						
						error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));

					}
					
					
				});
		
			  
			});	
		
		
		
		/*
					master trainer depending on language wet topic*/
		
		
		
		$('#inputLanguage').change(function(){
		  				
		  					var catgoryid=$(this).find(":selected").val();
		  					$.ajax({
		  					  	type: "GET",
		  			       		 url: "/loadByLangugaeTopic",
		  			       		 data: { "id": catgoryid},
		  			       		 contentType: "application/json",
		  			       		 success: function (result){
		  			       			 
		  			       		
		  			       		  var html = '';
		  	  			            var len = result.length;
		  	  			            html += '<option value="0">Select Topic</option>';
		  	  			            for (var i = 0; i < len; i++) {
			  			            	
		  	  			             html += '<option value="' + result[i] + '">'
		  	  			               + result[i]
		  	  			               + '</option>';
		  	  			            }
		  	  			            html += '</option>';
		  	  			            
		  	  			            $("#selectLanguageId").prop('disabled',false);
		  	  			            $('#selectLanguageId').html(html);
		  	  			            
		  	  						},
			  						
			 							error : function(err){
			  						console.log("not working. ERROR: "+JSON.stringify(err));
		 						}
			
		  					});
		  							  
		  				});
		
		//chages according to individual  table by languge 
		
		$('#catId').change(function(){
			
				var catgoryid=$(this).find(":selected").val();
				$.ajax({
				  	type: "GET",
		       		 url: "/loadBycategorylanguage",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select language</option>';
			            for (var i = 0; i < len; i++) {
			            	
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputLan").prop('disabled',false);
			            $('#inputLan').html(html);
			            
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}
					
					
				});
		
			  
			});
		

		/* Access topic according to langaueg*/
		
		$('#MasterCategoryId').change(function(){
		
				var catgoryid=$(this).find(":selected").val();
				$.ajax({
				  	type: "GET",
		       		 url: "/loadByCategoryByTopic",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select Topic</option>';
			            for (var i = 0; i < len; i++) {
			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            }
			            html += '</option>';
			            
			            $("#inputTopic").prop('disabled',false);
			            $('#inputTopic').html(html);
			            
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}

				});
				
			 
			  
			});
		
		
		/*
		Access language depending on topic contributer*/
		
		$('#inputTopic').change(function(){
			
				var catgoryid=$(this).find(":selected").val();
				$.ajax({
				  	type: "GET",
		       		 url: "/loadlanguage",
		       		 data: { "id": catgoryid},
		       		 contentType: "application/json",
		       		 success: function (result){
		       			 
		       		
		       		  var html = '';
			            var len = result.length;
			            html += '<option value="0">Select Languge</option>';
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






