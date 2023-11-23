const getAddress = async () => {
    return new Promise((resolve, reject) => {
        new window.daum.Postcode({
        oncomplete: (data) => {
        resolve(data);
        },
        onclose: (state) => {
        if (state === 'FORCE_CLOSE') {
            reject(new Error('Address search window is forcibly closed'));
        }
        },
    }).open();
    });
};

export default getAddress;