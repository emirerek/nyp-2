import { Divider, Stack } from "@mantine/core";
import Comment from "./Comment";

function CommentList({ comments }) {
    return (
        <Stack>
            {comments.map((comment) => {
                return (
                    <>
                        <Comment comment={comment} />
                        <Divider />
                    </>
                )
            })}
        </Stack>
    );
}

export default CommentList;