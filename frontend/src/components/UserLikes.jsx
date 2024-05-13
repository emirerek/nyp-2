import { Stack } from "@mantine/core";
import { useUserLikes } from "../util/hooks";
import PostList from "./PostList";

function UserLikes() {
    const [data, error] = useUserLikes();

	if (error) return <span>{error}</span>;
	if (data == null) return;
    return (
        <Stack>
            <PostList posts={data} />
        </Stack>
    );
}

export default UserLikes;