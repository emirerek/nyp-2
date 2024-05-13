import { Stack } from "@mantine/core";
import PostList from "../components/PostList";
import { usePosts } from "../util/hooks";

function PostsPage() {
    const [data, error] = usePosts();

	if (error) return <span>{error}</span>;
	if (data == null) return;
    return (
        <Stack>
            <PostList posts={data} />
        </Stack>
    );
}

export default PostsPage;