import { Stack, Text } from "@mantine/core";
import UserInfo from "./UserInfo";

function Comment({ comment }) {
    return (
        <Stack p={12}>
            <UserInfo user={comment.user} />
            <Text>
                {comment.textContent}
            </Text>
        </Stack>
    );
}

export default Comment;