const validateSearch = () => {
    const searchText = document.getElementById('search').value.trim()
    return searchText !== "";
}