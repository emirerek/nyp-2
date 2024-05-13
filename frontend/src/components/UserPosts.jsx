import { Stack } from "@mantine/core";
import PostList from "./PostList";
import { useUserPosts } from "../util/hooks";

function UserPosts() {
    const [data, error] = useUserPosts();

	if (error) return <span>{error}</span>;
	if (data == null) return;
    return (
        <Stack>
            <PostList posts={data} />
        </Stack>
    );
}

export default UserPosts;