import { Stack } from "@mantine/core";
import PostList from "../components/PostList";
import { useFollowedPosts } from "../util/hooks";

function FollowedPostsPage() {
    const [data, error] = useFollowedPosts();

	if (error) return <span>{error}</span>;
	if (data == null) return;
    return (
        <Stack>
            <PostList posts={data} />
        </Stack>
    );
}

export default FollowedPostsPage;