import { useState } from "react";
import { Group } from '@mantine/core';
import ButtonFollow from "./ButtonFollow";
import UserInfo from "./UserInfo";

function UserPreview({ user }) {
    return (
        <Group style={{width: "100%"}} justify="space-between" align="center">
            <UserInfo user={user} />
            <ButtonFollow followedUserId={user.id} />
        </Group>
    );
}

export default UserPreview;