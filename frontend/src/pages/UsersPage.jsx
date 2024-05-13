import { Card, Stack } from "@mantine/core";
import UserPreviewList from "../components/UserPreviewList";
import { useUsers } from "../util/hooks";

const dummyUser1 = {
	id: 2,
	username: "Doğan Güldağ",
	followers: 512,
	following: 645
}

const dummyUser2 = {
	id: 1,
	username: "Emir Erek",
	followers: 423,
	following: 1241
}

function UsersPage() {
    const [data, error] = useUsers();

	if (error) return <span>{error}</span>;
	if (data == null) return;
    return (
        <Stack>
            <UserPreviewList users={data} />
        </Stack>
    );
}

export default UsersPage;