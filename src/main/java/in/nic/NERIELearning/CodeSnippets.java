package in.nic.NERIELearning;

//@Id
//@GeneratedValue(generator = "uuid")
//@GenericGenerator(name = "uuid", strategy = "uuid2")
//@Column(name = "mStageId", nullable = false, unique = true, length = 5)
//private String mStageId;

//REPO
//public interface MStageRepo extends JpaRepository<MStage, String> {
//	@Query("SELECT s FROM MStage s WHERE s.mStageId = :id")
//	MStage findMStageByUUID(String id);
//}

//END: PRIMARY KEYS USING UUID (16 bytes)


//BACKUP 14th JULY 2024 (DASHBOARDSIDEBAR2)
//<!DOCTYPE html>
//<html lang="en" xmlns:th="http://www.thymeleaf.org">
//
//<head>
//<meta charset="UTF-8" />
//<title>NERIE Learning</title>
//
//<style>
//	.goalDesc {
//		cursor: pointer;
//	}
//	.competencyDesc {
//		cursor: pointer;
//	}
//</style>
//</head>
//
//<body>
//	<div th:insert="~{utils/keyImports :: head}"></div>
//	<div th:insert="~{utils/navbar :: nav}"></div>
//<!-- 	<div th:insert="~{utils/editorNavbar :: nav}"></div> -->
//<!-- 	<div th:insert="~{utils/editorNavbar :: aside}"></div> -->
//
//	<main>
//		<div class="card border-3 my-5 mx-3 text-center">
//			<div class="card-title mt-4 h1">Learning Outcomes</div>
//			<div class="card-body row mb-4 justify-content-around">
//				<div class="row mb-3">
//				<div class="text-start col-sm-12 col-md-4">
//					<label for="Class">Select a Class</label>
//				</div>
//					<div class="col-sm-12 col-md-8">
//						<select class="form-select" id="class_dropdown" name="class" autofocus>
//						<option th:each="mClass : ${listClasses}"
//							th:value="${mClass.mClassId}"
//							th:text="${mClass.mClassName}"></option>
//					</select>
//					</div>
//				<div class="row mb-3">
//				</div>
//					<div class="text-start col-sm-12 col-md-4">
//						<label for="Class">Select a Subject</label>
//					</div>
//					<div class="col-sm-12 col-md-8">
//						<select class="form-select" id="subject_dropdown" name="subject">
//					</select>
//					</div>
//				</div>
//				<table id="LoSas" class="display table table-striped lg-10 table-bordered">
//					<thead class="bg-grey">
//						<tr>
//							<th>Goal (Click on goal to view details)</th>
//							<th>Competency (Click on competency to view details)</th>
//							<th>Learning Outcome</th>
//							<th>Suggestive Activity</th>
//						</tr>
//					</thead>
//					<tbody id="tLoSaTableBody"> </tbody>
//					<tfoot></tfoot>
//				</table>
//			</div>
//		</div>
//	</main>
//
//	<footer th:insert="~{utils/footer :: footer}"></footer>
//</body>
//<script>
//	$(document).ready(function() {
//		var table = new DataTable('#LoSas');
//// 		let table = new DataTable('#LoSas', {
//// 			responsive: true,
//// 			ordering: true,
//// 			order: [
//// 		        [0, 'asc']
//// 		    ]
//// 		});
//
//		//END OF DATATABLES
//	  	//INIT
//        $("#subject_dropdown").append('<option id="subject_blank" selected="selected" value=""></option>').prop("disabled", true);
//
//		// Handle change event on dropdowns
//	  	$('body').on('change', '#class_dropdown', function() {
//			$('#subject_blank').prop('disabled', true);
//	    	const classId = $('#class_dropdown').val();
//			loadSubjectOptions(classId); // Load options for Subjects based on Class selection
//	  	});
//	  	$('body').on('change', '#subject_dropdown', function() {
//	    	const classId = $('#class_dropdown').val();
//	    	const subjectId = $('#subject_dropdown').val();
//			loadLoSas(table, classId, subjectId); // Load options for Subjects based on Class selection
//			
//		    $.getJSON('newTable', null, function (json) {
//		        table.destroy();
//// 		        $('#LoSas').empty(); // empty in case the columns change
//		 
//		        table = $('#LoSas').DataTable({
//		            columns: json.columns,
//		            data: json.rows
//		        });
//		    });
//	  	});
//	});
//	
//	function loadSubjectOptions(selectedClassId) {
//	  	$.ajax({
//	    	url: '/subjectListByClass',
//	    	type: "GET",
//		    data: 'classId=' + selectedClassId ,
//		    success: function(response) {
//
//				$('#subject_dropdown').html('');
//				$('#subject_dropdown').prop('disabled', false);
//				var content = '';
//
//				if(response.length > 0) {
//						content +='<option value="0">-- SELECT SUBJECT --</option>';					
//					for(var a=0;a<response.length;a++) {
//						content +='<option value="'+ response[a].msubjectId.msubjectId +'">'+ response[a].msubjectId.msubjectName +'</option>';
//					}
//				} else {
//					content +='<option selected="selected" disabled="disabled" value="">-- No subject for this class  --</option>';
//					$('#subject_dropdown').prop('disabled', true);
//
//				}
//				$('#subject_dropdown').html(content);
//		    },
//		    error: function(jqXHR, textStatus, errorThrown) {
//		      	console.error("Error loading TGoal options:", textStatus, errorThrown);
//		    }
//	  	});
//	}
//	
//	function loadLoSas(table, selectedClassId, selectedSubjectId) {
//	  	$.ajax({
//	    	url: '/losaByMapCSToo',
//	    	type: "GET",
//		    data: {
//				'selectedClassId': selectedClassId,
//				'selectedSubjectId': selectedSubjectId,
//		    },
// 		    success: function(response) {
//				console.log(response);
//
//				var content = '';
//				if(response.length > 0) {
//					
//// 					content += '<thead class="bg-grey"> <tr>'; 
//// 					content += '<th>Goal (Click on goal to view details)</th>';
//// 					content += '<th>Competency (Click on competency to view details)</th>';
//// 					content += '<th>Learning Outcome</th>';
//// 					content += '<th>Suggestive Activity</th>';
//// 					content += '</tr> </thead>';
//// 					content += '<tbody id="tLoSaTableBody">';
//					
//					for(var a=0;a<response.length;a++) {
//						content += '<tr>';
//						content += '<td class="goalDesc" th:attr="data-desc=${TLoSa.tCompetencyId.tGoalId.tGoalDescription}"">'+ response[a].tcompetencyId.tgoalId.tgoalName +'</td>';
//						content += '<td class="competencyDesc" th:attr="data-desc=${TLoSa.tCompetencyId.tCompetencyDescription">'+ response[a].tcompetencyId.tcompetencyName +'</td>';
//						content += '<td>'+ response[a].learningOutcome +'</td>';
//						content += '<td>'+ response[a].suggestiveActivity +'</td>';
//						content += '</tr>';
//					}
//
//					$('.goalDesc').on('click', function() {
//						var gd = $(this).data('desc');
//						alert(gd);
//					});
//					$('.competencyDesc').on('click', function() {
//						var cd = $(this).data('desc');
//						alert(cd);
//					});
//					
//// 					content += ' </tbody><tfoot></tfoot>';
//				} else {
//					content += '<tr><td colspan="4"> -- No Learning Outcomes and Suggestive Activities for this class and subject -- </td></tr>';
//				}
//				
//// 				$('#LoSas').html(content);
//				$('#tLoSaTableBody').html(content);
//		    },
//		    error: function(jqXHR, textStatus, errorThrown) {
//		      	console.error("Error loading TGoal options:", textStatus, errorThrown);
//		    }
//	  	});
//	}
//</script>
//</html>
