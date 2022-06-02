const submitForm = () => {
    const submitButton = '#submit';
    const submitUrl = 'http://localhost:8080/survey/new';

    const fields = {
        name: '#name',
        male: '#radioMale',
        female: '#radioFemale',
        footbal: '#footballRadio',
        basketball: '#basketballRadio',
        jockey: '#jockeyRadio',
        baseball: '#baseballRadio',
        golf: '#golfRadio',
        studyLevel: '#selectLvlStudy',
        television: '#televisionRadio',
        cocina: '#kitchenRadio',
        tecnologia: '#techRadio',
        musica: '#musicRadio',
        deporte: '#sportRadio',
    };

    // UPDATE props
    Date.prototype.addHours = function (h) {
        this.setTime(this.getTime() - h * 60 * 60 * 1000);
        return this;
    };

    const formData = () => {
        return {
            nombre: $(fields.name).val(),
            sexo: $(fields.male).is(':checked') ? $(fields.male).val() : $(fields.female).val(),
            deporteFavorito: (() => {
                if ($(fields.footbal).is(':checked')) {
                    return $(fields.footbal).val();
                }
                if ($(fields.basketball).is(':checked')) {
                    return $(fields.basketball).val();
                }
                if ($(fields.jockey).is(':checked')) {
                    return $(fields.jockey).val();
                }
                if ($(fields.baseball).is(':checked')) {
                    return $(fields.baseball).val();
                }
                if ($(fields.golf).is(':checked')) {
                    return $(fields.golf).val();
                }
            })(),
            nivelEstudio: $(fields.studyLevel).find(':checked').text(),
            temas: (() => {
                if ($(fields.television).is(':checked')) {
                    return $(fields.television).val();
                }
                if ($(fields.cocina).is(':checked')) {
                    return $(fields.cocina).val();
                }
                if ($(fields.tecnologia).is(':checked')) {
                    return $(fields.tecnologia).val();
                }
                if ($(fields.musica).is(':checked')) {
                    return $(fields.musica).val();
                }
                if ($(fields.deporte).is(':checked')) {
                    return $(fields.deporte).val();
                }
            })(),
            fecha: new Date().addHours(6).toISOString().slice(0, 19).replace('T', ' '),
        };
    };

    $(submitButton).click(() => {
        // PREPARE OBJECT
        const data = formData();

        $.ajax({
            contentType: 'application/json; charset=utf-8',
            mode: 'cors',
            cache: false,
            type: 'POST',
            url: submitUrl,
            data: JSON.stringify(data),
            success: () => {
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: 'Encuesta enviada',
                    showConfirmButton: false,
                    timer: 1500,
                });
            },
        });
    });
};

export default submitForm;
