


$(function(){

/*	$('#keywordModale').on('hidden.bs.modal', function () {
		location.reload();
	});*/
	
	
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
			alert("Hi");
		
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
				
		/*load Topic by catgory contributor*/
		
		$('#categoryContributor').change(function(){
		
			var catgoryid=$(this).find(":selected").val();
				
			$.ajax({
					
				  	type: "GET",
		       		 url: "/loadTopicByCategoryContributor",
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
			            
			            $("#inputTopicContributor").prop('disabled',false);
			            $('#inputTopicContributor').html(html);
			            
						},
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}

				});
			  
			});
		
		/*contributor languages*/
		
		$('#inputTopicContributor').change(function(){
	
			var catgoryid=$(this).find(":selected").val();
				$.ajax({
					
				  	type: "GET",
		       		 url: "/loadLanguageByTopicId",
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
			            
			            $("#inputLanguageContributor").prop('disabled',false);
			            $('#inputLanguageContributor').html(html);
			            
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
		
		
		$('#outlineId').click(function()	
		{
		
			var saveInfo=editor.getData();
			var keywordArea=$("#keyword").val();
			var categoryid=$("#categoryId").val();
			var topicid=$("#topicId").val();
			var lanId=$("#lanId").val();

			$.ajax({
			  	type: "GET",
	       		 url: "/outline",	
	       		 data: { "saveOutline": saveInfo,"id": keywordArea,"categorname" : categoryid,"topicid":topicid,"lanId":lanId},
	       		 contentType: "application/json",
	       		 success: function(result)
	       		 {
	       			 
	       			 $("#statusOutline").prop('disabled',false);
	       			 $('#statusOutline').html(html);
	       			 
					},		
						error : function(err){
					console.log("not working. ERROR: "+JSON.stringify(err));
				}

			});
  
		});
		
		/*Save keyWord information into table*/
		
	
		$('#keywordId').click(function()			
		{
				
				var keywordArea=$("#keyword").val();
				var categoryid=$("#categoryId").val();
				var topicid=$("#topicId").val();
				var lanId=$("#lanId").val();
			
				$.ajax({
					  	type: "GET",
			       		 url: "/keyword",
			       		 data: { "id": keywordArea,"categorname" : categoryid,"topicid":topicid,"lanId":lanId },			
			       		 contentType: "application/json",
			       		 success: function(result)
			       		 {
			     
			       			 $("#statuskeyword").prop('disabled',false);
			       			 $('#statuskeyword').html(result);
			       		
							},
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}

					});
		  
				});
		
		/*
		Here is code for script*/
		
		
		$('#scriptId').click(function()	
				{
			
			
			
							var categoryid=$("#categoryId").val();
							var topicid=$("#topicId").val();
							var lanId=$("#lanId").val();
							
							
							var form = $('#upload-file-form-script')[0]; 
							var formData = new FormData(form); 
		
						
							formData.append('categoryid', categoryid);
							formData.append('topicid', topicid);
							formData.append('lanId', lkeywordModaleViewanId);
							 
					
							
							$.ajax({
								
								type: "POST",
							    url: "/scriptUpload",
							    data: formData,
							    enctype: 'multipart/form-data',
							    processData: false,
							    contentType: false,
							    cache: false,
							    success: function (result)
							{
								    	
							    	
							
						    
						       			 $("#statusofScript").prop('disabled',true);
						       			 $('#statusofScript').html(result);				       								
							 },
						
							error : function(err){
						console.log("not working. ERROR: "+JSON.stringify(err));
					}
							 keywordModaleView
				});
	  
			});
		
		
		
		
		/*here we write  code for slide 
		*/
		

			$('#slideId').click(function()	
			{
		
						var categoryid=$("#categoryId").keywordModaleViewval();
						var topicid=$("#topicId").val();
						var lanId=$("#lanId").val();
						
						
						var form = $('#upload-file-form')[0]; 
						var formData = new FormData(form); 
	
					
						formData.append('categoryid', categoryid);
						formData.append('topicid', topicid);
						formData.append('lanId', lanId);

						$.ajax({
							    type: "POST",
							    url: "/slideUpload",
							    data: formData,keywordModaleView
							    enctype: 'multipart/form-data',
							    processData: false,
							    contentType: false,
							    cache: false,
							    success: function (result)
							    {
							    	
					    
					       			 $("#statusofSlide").prop('disabled',true);
					       			 $('#statusofSlide').html(result);				       		
					
							    },
					
						error : function(err){
					console.log("not working. ERROR: "+JSON.stringify(err));
				}
							    keywordModaleView
			});
  
		});
			
	/*		video for thumnail and video*/
			
			
	$('#videoId').click(function()	
		{
				
								var categoryid=$("#categoryId").val();
								var topicid=$("#topicId").val();
								var lanId=$("#lanId").val();
								
								
								var form = $('#upload-file-form-video')[0]; 
								var formData = new FormData(form); 
			
							
								formData.append('categoryid', categoryid);
								formData.append('topicid', topicid);
								formData.append('lanId', lanId);
								
			
							$.ajax({keywordModaleView
									    type: "POST",
									    url: "/videoUpload",
									    data: formData,
									    enctype: 'multipart/form-data',
									    processData: false,
									    contentType: false,
									    cache: false,
									    success: function (result)
									    {
									    	
							    
							       			 $("#statusofVideo").prop('disabled',true);
							       			 $('#statusofVideo').html(result);				       		
							       			 
									    },
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}

					});
		  
				});
	
	
	
	$('#PrerequisiteVideoId').click(function()	
	{
				
								var categoryid=$("#categoryId").val();
								var topicid=$("#topicId")keywordModaleView.val();
								var lanId=$("#lanId").val();
								
								
								var form = $('#upload-file-form-prerequisite')[0]; 
								var formData = new FormData(form); 
			
							
								formData.append('categoryid', categoryid);
								formData.append('topicid', topicid);
								formData.append('lanId', lanId);
				
							$.ajax({
									    type: "POST",
									    url: "/prerequisite",
									    data: formData,
									    enctype: 'multipart/form-data',
									    processData: false,
									    contentType: false,
									    cache: false,
									    success: function (result)
									    {
									    	alert("succeskeywordModaleViews");
							    
							       			 $("#statusofprerequisite").prop('disabled',true);
							       			 $('#statusofprerequisite').html(result);				       		
							       			 
									    },
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}

					});
		  
				});
	
	
			
			
			
	$('#myCheck').click(function()			 
	{
				
		var checkbox=$("#myCheck").val();
			
				$.ajax({
					
					  	type: "GET",
			       		 url: "/keyword",
			       		 data: { "id": keywordArea },			
			       		 contentType: "application/json",
			       		 success: function(result)
			       		 {
			       			 $("#statuskeyword").prop('disabled',false);
			       			 $('#statuskeyword').html(result);
			       		
							},
							
								error : function(err){
							console.log("not working. ERROR: "+JSON.stringify(err));
						}

					});
		  
				});
	
	
	/*here  calling approve button for contributor */
	
	$('#approveContributorId').click(function()			
	{
		
		
		
				var contributionId=$("#contributorId").val();
				
						$.ajax({
							  	type: "GET",
					       		 url: "/addContributerRoleById",
					       		 data: { "id": contributionId},			
					       		 contentType: "application/json",
					       		 success: function(result)
					       		{

				       			 $("#statusContributor").prop('disabled',false);
				       			 $('#statusContributor').html(result);
					       	
					       		},
										
									error : function(err){
									console.lo3g("not working. ERROR: "+JSON.stringify(err));
								}

							});
						
						$("#approveContributorId").attr("disabled", true);
						
				  
			});
	
	$('#rejectContributionId').click(function()			
			{
	
						var contributionId=$("#contributorId").val();
						
								$.ajax({
									  	type: "GET",
							       		 url: "/rejectContributorById",
							       		 data: { "id": contributionId},			
							       		 contentType: "application/json",
							       		 success: function(result)
							       		{

					       			 $("#statusContributor").prop('disabled',false);
					       			 $('#statusContributor').html(result);
						       	
									},
												
											error : function(err){
											console.log("not working. ERROR: "+JSON.stringify(err));
										}

									});
						  
					});
			
			/*load By Contributor user only //Contributor assign from 	*/
	
	
			$('#contributorId').click(function()			
			{	
				
				var userContributor=$(this).find(':selected').val();

								$.ajax({
									type: "GET",
						       		 url: "/loadLanguageByUser",
						       		 data: { "id": userContributor},
						       		 contentType: "application/json",
						       		 success: function (result){
		
						       			 	
						       			 var html = '';
						       			 var len = result.length;
							             html += '<option value="0">Select Language</option>';
							             for (var i = 0; i < len; i++) {
							             html += '<option value="' + result[i] + '">'
							               + result[i]
							               + '</option>';
							             }
							             html += '</option>';
							            
							            $("#lanId").prop('disabled',false);
							            $('#lanId').html(html);
							            
										},
										
										error : function(err){
											console.log("not working. ERROR: "+JSON.stringify(err));
										}
									});

								
							
				});
				
			
			
	$('#lanId').click(function()			
	{			
							var languageName=$("#lanId :selected").text();
					
								$.ajax({
											type: "GET",
								       		 url: "/loadCategoryByLanguage",
								       		 data: { "id": languageName},
								       		 contentType: "application/json",
								       		 success: function (result){
				
								       			 	
								       			 var html = '';
								       			 var len = result.length;
									             html += '<option value="0">Select Category</option>';
									             for (var i = 0; i < len; i++) {
									             html += '<option value="' + result[i] + '">'
									               + result[i]
									               + '</option>';
									             }
									             html += '</option>';
									            
									            $("#catgoryByContributor").prop('disabled',false);
									            $('#catgoryByContributor').html(html);
									            
												},
												
												error : function(err){
													console.log("not working. ERROR: "+JSON.stringify(err));
												}
											});
								  
						});	
					
						$('#catgoryByContributor').click(function()			
						{			
								var category=$(this).find("option:selected").val();
	
									$.ajax({
													 type: "GET",
										       		 url: "/loadTopicByCategory",
										       		 data: { "id": category },
										       		 contentType: "application/json",
										       		 success: function (result){
						
										       			 1	
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
			
				/*load By Contributor user only //Contributor assign from End	*/
				
	
/*		$('#revokeId').on('hidden.bs.modal', function () {
				
				location.reload();
			});*/
		/*				
		$('#approveContributorId').on('hidden.bs.modal',function () {
			
			location.reload();
		});*/
	
		
		


});






