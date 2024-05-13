import { Divider, Stack, Text } from "@mantine/core";
import CommentList from "../components/CommentList";
import Post from "../components/Post";
import { IconMessageCircle } from "@tabler/icons-react";
import { usePost, usePostComments } from "../util/hooks";
import CommentForm from "../components/CommentForm";

function PostPage() {
    const [postData, postError] = usePost();
    const [commentData, commentError] = usePostComments();

    if (postError || commentError) return <span>Error</span>;
	if (postData == null || commentData == null) return;
    return (
        <Stack>
            <Post post={postData} />
            <CommentForm postId={postData.id} />
            <Divider 
                label={
                    <>
                        <IconMessageCircle size={20} />
                        <Text size="xl" ml={6}>
                            {postData.commentCount} Comments
                        </Text>
                    </>
                }
                labelPosition="left"
            />
            <CommentList comments={commentData} />
        </Stack>
    );
}

export default PostPage;