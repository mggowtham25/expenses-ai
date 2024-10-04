import { BrowserRouter, Navigate, Route, Routes as Switch } from "react-router-dom";
import SignIn from "../login/SignIn";
import SignUp from "../login/signup/SignUp";
import { RouteType } from "../types/types";
import { Suspense } from "react";

const routes: RouteType[] = [
    { path: "/signIn", name: "Sign In", component: SignIn },
    { path: "/signup", name: "Sign Up", component: SignUp }
];

const AppContent = () => {
    return (
        <>
            <BrowserRouter>
                <Suspense>
                    <Switch>
                        {
                            routes.map((route: RouteType, index: number) => {
                                return (
                                    <Route
                                        key = { index }
                                        path = { route.path }
                                        element = { <route.component /> }
                                    />
                                );
                            })
                        }
                        <Route path = "/" element = { <Navigate to = "/signIn" /> } />
                        <Route path = "*" element = { <Navigate to = "/signIn" /> } />
                    </Switch>
                </Suspense>
            </BrowserRouter>

        </>
    );
};
export default AppContent;
