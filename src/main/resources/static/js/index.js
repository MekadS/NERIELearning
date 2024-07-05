const checkCaptcha = () => {
	const captcha = document.getElementById("captcha");
	const hiddenCaptcha = document.getElementById("hiddenCaptcha");

	if (captcha.value != hiddenCaptcha.value) {
		captcha.value = "";

		Swal.fire({
			icon: "error",
			title: "Error!",
			text: "Captcha Does Not Match!",
			confirmButtonText: "Okay",
		});
	}
};

const reloadCaptcha = () => {
	const realCaptcha = document.getElementById("realCaptcha");
	const hiddenCaptcha = document.getElementById("hiddenCaptcha");

	$.ajax({
		url: "/refresh-captcha",
		method: "GET",
	})
		.done(function(response) {
			hiddenCaptcha.value = response.hiddenCaptcha;
			realCaptcha.src =
				"data:realCaptcha/jpg;base64," + response.realCaptcha;
		})
		.fail(function() {
			self.setContent("Something went wrong.");
		});
};

$(document).ready(function() {
});