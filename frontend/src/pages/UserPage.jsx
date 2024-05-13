import { Outlet } from "react-router-dom";
import { Stack } from "@mantine/core";
import User from "../components/User";
import { useUser } from "../util/hooks";

function UserPage() {
    const [data, error] = useUser();

    if (error) return <span>{error}</span>;
	if (data == null) return;
    return (
        <Stack>
            <User user={data} />
            <Outlet />
        </Stack>
    );
}

export default UserPage;