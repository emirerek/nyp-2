const getInitialsFromUsername = (username) => {
    const arr = username.split(" ");
    if (arr.length < 2) return username[0];
    let initials = "";
    arr.forEach((word) => {
        if (initials.length == 3) return;
        initials += word[0];
    })
    return initials;
}

const convertToDate = (timestamp) => {
    return new Date(timestamp).toLocaleDateString("tr-TR");
}

export { getInitialsFromUsername, convertToDate }