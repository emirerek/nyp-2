import { Stack } from "@mantine/core";
import { useUserComments } from "../util/hooks";
import CommentList from "./CommentList";

function UserComments() {
    const [data, error] = useUserComments();

	if (error) return <span>{error}</span>;
	if (data == null) return;
    return (
        <Stack>
            <CommentList comments={data} />
        </Stack>
    );
}

export default UserComments;