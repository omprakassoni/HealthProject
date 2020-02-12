

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

			             html += '<option value="' + result[i] + '">'
			               + result[i]
			               + '</option>';
			            
		       		
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
		Here is code for save script*/
		
		
		$('#scriptId').click(function()	
		{
		
			

					
							var categoryid=$("#categoryId").val();
							var topicid=$("#topicId").val();
							var lanId=$("#lanId").val();
							
							
							var form = $('#upload-file-form-script')[0]; 
							var formData = new FormData(form); 
		
						
							formData.append('categoryid', categoryid);
							formData.append('topicid', topicid);
							formData.append('lanId', lanId);	
							
					
							
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
							 
				});
	  
			});
		
		
		
		
		/*here we write  code for slide 
		*/
		

			$('#slideId').click(function()	
			{
		
						var categoryid=$("#categoryId").val();
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
							    data: formData,
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
								
			
							$.ajax({
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
								var topicid=$("#topicId").val();
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
									    	alert("success");
							    
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
			
	
						//here write code for keyword view	//add content form
						
						
						$('#keywordModaleView').click(function()			
								{
												
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												
												$.ajax({
													  	type: "GET",
											       		 url: "/viewKeyword",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },			
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 {

											       			 
											       			 $("#keywordView").prop('disabled',false);
											       			 $('#keywordView').html(result);
											       		
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
						
				$('#videoViewId').click(function()			
				{
											
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												
												alert(categoryid+""+topicid+""+lanId);
												var x;
												
												$.ajax({
													
													  	type: "GET",
											       		 url: "/viewVideo",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 {
											       					 
											       			
											       			 //$("#VideoView").prop('disabled',false);
											       			 //$('#VideoView').html(result);
											       			
											       		        var res =  result;
											       		        //alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4

											       		        source =  document.getElementById('storedVideoId');
											       		        source.setAttribute('src', res);
											       		        source.setAttribute('type','video/mp4')

											       		        source.play(); //test playback of new video
											       		        
											       		       // $('#videoDiv').show()
											       		   
											       		
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
						
						
						//here code outline View
						
						$('#outlineViewModel').click(function()			
						{
							
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
												$.ajax({
													
													  	type: "GET",
											       		 url: "/outlineView",
											       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
											       		 contentType: "application/json",
											       		 success: function(result)
											       		 {
											       			 
											       			 $("#outlineViewResponse").prop('disabled',false);
											       			 $('#outlineViewResponse').html(result);
											       		
															},
															
																error : function(err){
															console.log("not working. ERROR: "+JSON.stringify(err));
														}
								
													});
										  
												});
						
						//Script View  Contributor
						
					
						$('#viewScriptId').click(function()			
						{
											
																var categoryid=$("#categoryId").val();
																var topicid=$("#topicId").val();
																var lanId=$("#lanId").val();
																$.ajax({
																	
																	  	type: "GET",
															       		 url: "/scriptPdf",
															       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
															       		 contentType: "application/json",
															       		 success: function(result)
															       		 {
															       		 	var res =  result;
															       		      //  alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4

															       		        source =  document.getElementById('ScriptPdf');
															       		        source.setAttribute('href',res);
															       		        
															       		       // source.setAttribute('type','video/mp4')
															       		        source.play(); 
															       			 
															      
																			},
																			
																				error : function(err){
																			console.log("not working. ERROR: "+JSON.stringify(err));
																		}
												
																	});
														  
																});
						
						
						//Contributor Script modelView
						
							$('#slideModaleView').click(function()			
								{
											
																var categoryid=$("#categoryId").val();
																var topicid=$("#topicId").val();
																var lanId=$("#lanId").val();
																$.ajax({
																	
																	  	type: "GET",
															       		 url: "/sliedPdf",
															       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
															       		 contentType: "application/json",
															       		 success: function(result)
															       		 {
															       		 	var res =  result;
															       		      //  alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4

															       		        source =  document.getElementById('sliedPdf');
															       		        source.setAttribute('href',res);
															       		       // source.setAttribute('type','video/mp4')

															       		        source.play(); 
															       			 
															      
																			},
																			
																				error : function(err){
																			console.log("not working. ERROR: "+JSON.stringify(err));
																		}
												
																	});
														  
																});
							
							//Display  comment box for need to improvemnet
							
							$('#AddrType').click(function()			
								{
										
										var vals=$("#AddrType").val();
										
										 if(vals === '0'){
											 
											  $('#NeedImprovement').css({'visibility':'hidden'});         
						 		          
										 }
										 else if(vals === '1'){
											 
											  $('#NeedImprovement').css({'visibility':'visible'}); 
											 
										 }
											  
									});
							
							$('#scriptAccept').click(function()			
								{	
								
										var vals=$("#scriptAccept").val();
	
										 if(vals === '0')
										 { 
											  $('#scriptNeedImprovement').css({'visibility':'hidden'});         
						 		          }
										 else if(vals==='1'){
											 
											  $('#scriptNeedImprovement').css({'visibility':'visible'}); 
										 }
										 
											  
									});
							
							
							$('#VideoAccept').click(function()			
									{
								
											//var vals=$("#VideoAccept").val();
											
											var vals=$(this).find(":selected").val();
		
										
											 if(vals === '0')
											 { 
												  $('#videoNeedImprovement').css({'visibility':'hidden'}); 
												  
							 		          }
											 else if(vals === '1')
											 {
												 
												 $('#videoNeedImprovement').css({'visibility':'visible'}); 											 
												 

											 }
												  
										});
							
						
							
							
			$('#VideoAcceptAdmin').click(function()			
					{
				
							var vals=$(this).find(":selected").val();
							
							
							
							 if(vals === '0')
							 { 
								  $('#videoNeedImprovement').css({'visibility':'hidden'}); 
								  
								  alert("Hi  Demo examplwe");
								  
			 		          }
							 else if(vals === '1'){
								 
					
								  $('#videoNeedImprovement').css({'visibility':'hidden'}); 

							 }
							 else if(vals === '2')
							 {
								 
								 $('#videoNeedImprovement').css({'visibility':'visible'}); 											 
								 

							 }
							 
							 
					});
	
						//Display domain Outline
					
							$('#outlineViewModelDomain').click(function()			
						{
									
								
															var categoryid=$("#categoryId").val();
															var topicid=$("#topicId").val();
															var lanId=$("#lanId").val();
															$.ajax({
																
																  	type: "GET",
														       		 url: "/outlineViewDomain",
														       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
														       		 contentType: "application/json",
														       		 success: function(result)
														       		 {
														       		
														       			$("#outlineViewResponseDomain").prop('disabled',false);
														       			$('#outlineViewResponseDomain').html(result);
														       		
														       		 },
																		
																			error : function(err){
																		console.log("not working. ERROR: "+JSON.stringify(err));
																	}
											
																});
													  
															});
							
					/*		View Script from domain */
							
							$('#viewScriptIdDomain').click(function()			
						 {
								
													var categoryid=$("#categoryId").val();
													var topicid=$("#topicId").val();
													var lanId=$("#lanId").val();
											
								$.ajax({
																			 type: "get",
																       		 url: "/scriptPdfDomain",
																       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
																       		 contentType: "application/json",
																       		 success: function(result)
																       		 {
																       			var res = result;
																       			 
																       			 alert("NEW video path :" + res); 
																       			 
																       		        source =  document.getElementById('scriptPdfDomain');
																       		        source.setAttribute('href',res);
																       		        

																				},
																				
																					error : function(err){
																				console.log("not working. ERROR: "+JSON.stringify(err));
																			}
													
																		});
															  
																	});
								
							/*view Video By Domain*/
							
							$('#videoViewIdDomain').click(function()			
						{
											
								
												var categoryid=$("#categoryId").val();
												var topicid=$("#topicId").val();
												var lanId=$("#lanId").val();
																	
											$.ajax({
																		
														type: "GET",
														url: "/viewVideoDomain",
														data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
														contentType: "application/json",
														success: function(result)
													 {
											       					 
											       		
											       		      var res = result;
											       		      
											       		   //  alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4


											       		        source =  document.getElementById('storedVideoIdDomain');
											       		        source.setAttribute('src', "http://localhost:8081/"+res);
											       		        source.setAttribute('type','video/mp4')

											       		        source.play(); 

											       		        
															},
																												  
																				error : function(err){
																				console.log("not working. ERROR: "+JSON.stringify(err));
																			}
													
																		});
															  
																	});
							
							
							/*Here is code for comment on componenet outline*/
							
								$('#submitCommentId').click(function()			
								{
									alert("call submit");
												
																	var categoryid=$("#categoryId").val();
																	var topicid=$("#topicId").val();
																	var lanId=$("#lanId").val();
																	var commentOutlineMsg=$("#msgCommentOutline").val();
																	
																	alert(commentOutlineMsg);
																	
																	$.ajax({
																		
																		  	type: "GET",
																       		 url: "/commentOnOutline",
																       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"commentOutlineMsg":commentOutlineMsg,},		
																       		 contentType: "application/json",
																       		 success: function(result)
																       		 {
																       			 $("#saveComment").prop('disabled',false);
																       			 $('#saveComment').html(result);
																       		
																       			 
																				},
																				
																					error : function(err){
																				console.log("not working. ERROR: "+JSON.stringify(err));
																			}
													
																		});
															  
																	});		
							
							
			/*Here is code for comment on componenet script*/
							
					$('#scriptAcceptOrNeedToImprovemenet').click(function()			
										{
													
														
																			var categoryid=$("#categoryId").val();
																			var topicid=$("#topicId").val();
																			var lanId=$("#lanId").val();
																			var msgScript=$("#msgScript").val();
																			
																		
																			
																			$.ajax({
																				
																				  	type: "GET",
																		       		 url: "/commentOnScript",
																		       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"msgScript":msgScript},		
																		       		 contentType: "application/json",
																		       		 success: function(result)
																		       		 {
																		       			 
																		       			 
																		       			 $("#saveCommentScript").prop('disabled',false);
																		       			 $('#saveCommentScript').html(result);
																		       		
																		       			 
																						},
																						
																							error : function(err){
																						console.log("not working. ERROR: "+JSON.stringify(err));
																					}
															
																				});
																	  
																			});	
					
					/*Here is code for comment on componenet Video*/
					
					$('#videoAcceptOrNeedToImprovemenet').click(function()			
					{
								
											
																var categoryid=$("#categoryId").val();
																var topicid=$("#topicId").val();
																var lanId=$("#lanId").val();
																var videoCommentMsg=$("#videoCommentMsg").val();
																
																
																
																$.ajax({
																	
																	  	type: "GET",
															       		 url: "/commentOnVideo",
															       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId,"videoCommentMsg":videoCommentMsg},		
															       		 contentType: "application/json",
															       		 success: function(result)
															       		 {
															       			
															       			
															       			 $("#saveCommentVideo").prop('disabled',false);
															       			 $('#saveCommentVideo').html(result);
															       		
															       			 
																			},
																			
																				error : function(err){
																			console.log("not working. ERROR: "+JSON.stringify(err));
																		}
												
																	});
														  
																});	
					
					
					
			/*		Here is code for admin Video*/
					
					$('#videoViewIdAdmin').click(function()			
							{
														
															var categoryid=$("#categoryId").val();
															var topicid=$("#topicId").val();
															var lanId=$("#lanId").val();
														
															
															$.ajax({
																
																  	type: "GET",
														       		 url: "/viewVideoAdmin",
														       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
														       		 contentType: "application/json",
														       		 success: function(result)
														       		 {
														       					 
														       			
														       			 //$("#VideoView").prop('disabled',false);
														       			 //$('#VideoView').html(result);
														       			
														       		        var res =  result;
														       		        //alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4

														       		        source =  document.getElementById('storedVideoId');
														       		        source.setAttribute('src', "http://localhost:8081/"+res);
														       		        source.setAttribute('type','video/mp4')

														       		        source.play(); //test playback of new video
														       		        
														       		       // $('#videoDiv').show()
														       		
																		},
																		
																			error : function(err){
																		console.log("not working. ERROR: "+JSON.stringify(err));
																	}
											
																});
													  
															});
					
				
					
					$('#videoViewIdAdmin').click(function()			
							{
														
															var categoryid=$("#categoryId").val();
															var topicid=$("#topicId").val();
															var lanId=$("#lanId").val();
														
															
															$.ajax({
																
																  	type: "GET",
														       		 url: "/viewVideoAdmin",
														       		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
														       		 contentType: "application/json",
														       		 success: function(result)
														       		 {
														       		
														       		        var res =  result;
														       		        
														       		        //alert("NEW video path : " + res); //should be a valid path eg: https://example.com/myvideo.mp4

														       		        source =  document.getElementById('storedVideoId');
														       		     source.setAttribute('src', "http://localhost:8081/"+res);
														       		        source.setAttribute('type','video/mp4')

														       		        source.play(); //test playback of new video
														       		        
														       		       // $('#videoDiv').show()
														       		   
														       		
																		},
																		
																			error : function(err){
																		console.log("not working. ERROR: "+JSON.stringify(err));
																	}
											
																});
													  
															});
					
					
					/*here is code for video accepet or need to improvement*/
					
					$('#videoAcceptOrNeedToImprovemenetByAdmin').click(function()			
					{
						
						var categoryid=$("#categoryId").val();
						var topicid=$("#topicId").val();
						var lanId=$("#lanId").val();
					
						
						var vals=$("#VideoAcceptAdmin").val();
						
						alert(vals);
						
						if(vals == '0')
						 { 
							  alert("Select Accept Or Need To Improvement"); 
							  
		 		          }
						 else if(vals == '1'){
							
							 
								$.ajax({
									
								  	type: "GET",
						       		 url: "/acceptAdminVideo",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{

						       			
						       			 
					       			 $("#statusVideoByAdmin").prop('disabled',false);
					       			 $('#statusVideoByAdmin').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});	 
							  

						 }
						 else if(vals == '2')
						 {
							 
							$.ajax({
									
								  	type: "GET",
						       		 url: "/needToImprovemenet",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{

	 
					       			 $("#statusVideoByAdmin").prop('disabled',false);
					       			 $('#statusVideoByAdmin').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});									 
							 

						 }
						

					});
					
					
					/*here is code for domain review  Video Acdept or Need To improvemenet*/
					
					$('#VideoAcceptDomain').click(function()			
							{
						
									var vals=$("#VideoAcceptDomain").val();
				
									 if(vals === '0')
									 { 
										  $('#videoNeedImprovement').css({'visibility':'hidden'}); 
					 		          }
									 else if(vals === '1')
									 {
										 	$('#videoNeedImprovement').css({'visibility':'hidden'}); 
				
									 }
									 else if(vals === '2')
									 {
										 
										 $('#videoNeedImprovement').css({'visibility':'visible'}); 											 
										 

									 }
									 
									 
							});
					
	/*here is code for video accepet or need to improvement*/
					
		$('#videoAcceptOrNeedToImprovemenetByDomain').click(function()			
		{
					
					
						var categoryid=$("#categoryId").val();
						var topicid=$("#topicId").val();
						var lanId=$("#lanId").val();
					
						
						var vals=$("#VideoAcceptDomain").val();
						
						alert(vals);
						
						if(vals == '0')
						 { 
							  alert("Select Accept Or Need To Improvement"); 
							  
		 		          }
						 else if(vals == '1')
						 {
							 alert("save");
						
								$.ajax({
									
								  	type: "GET",
						       		 url: "/acceptVideoByDomain",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{
						       			 			alert(result);
					       			 $("#statusVideoByDomain").prop('disabled',false);
					       			 $('#statusVideoByDomain').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});	 
							  

						 }
						 else if(vals == '2')
						 {
							 
					$.ajax({
									
								  	type: "GET",
						       		 url: "/needToImprovemenetByDomain",
						    		 data: { "categorname" : categoryid,"topicid":topicid,"lanId":lanId },		
						       		 contentType: "application/json",
						       		 success: function(result)
						       		{
						       			 
					       			 $("#statusVideoByDomain").prop('disabled',false);
					       			 $('#statusVideoByDomain').html(result);
						       	
						       		},
											
										error : function(err){
										console.lo3g("not working. ERROR: "+JSON.stringify(err));
									}

								});									 
							 

						 }
						

					});
					
					
				
					
					
					

});



