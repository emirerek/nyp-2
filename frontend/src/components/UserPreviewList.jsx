import { Card } from "@mantine/core";
import UserPreview from "./UserPreview";

function UserPreviewList({ users }) {
    return users.map((user) => {
        return (
            <Card>
                <UserPreview user={user} />
            </Card>
        );
    });
}

export default UserPreviewList;